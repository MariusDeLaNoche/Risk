package com.risk.metier;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import com.risk.beans.AdjacencyBean;
import com.risk.beans.PlayerBean;
import com.risk.beans.RegionBean;
import com.risk.beans.RuleBean;
import com.risk.beans.ZoneBean;
import com.risk.dao.AdjacencyDAO;
import com.risk.dao.EndDAO;
import com.risk.dao.MapDAO;
import com.risk.dao.MoveDAO;
import com.risk.dao.RegionDAO;
import com.risk.dao.ZoneDAO;

/**
 * 
 * @author Giraud
 * Objet de création, gestion des beans
 */
public class BeanCreator {
	private MapDAO dao;
	private RuleBean rule;
	private List<PlayerBean> listPlayers;
	private List<RegionBean> listRegions;
	private List<ZoneBean> listZones;
	
	/**
	 * Constructeur
	 * @param mapDao DAO du XML
	 * @throws NoSuchElementException
	 */
	public BeanCreator(MapDAO mapDao) throws NoSuchElementException{
		this.dao = mapDao;
		
		this.rule = new RuleBean();
		this.rule.setDivisor(mapDao.getDivisor());
		this.rule.setMinimal(mapDao.getMinimal());
		
		this.listRegions = new ArrayList<>();
		this.listZones = new ArrayList<>();
		
		// Ajoute chaque région à la liste des régions
		for(RegionDAO regionDao : dao.getRegions().getListRegion()) {
			RegionBean region = new RegionBean(regionDao.getName().replaceAll("\\s", ""), regionDao.getBonus());
			listRegions.add(region);
		}
		
		// Récupère chaque Zone et l'associe aux régions qu'elle contient
		for(ZoneDAO zoneDao : dao.getZones().getListZone()) {
			ZoneBean zone = new ZoneBean(zoneDao.getName().replaceAll("\\s", ""), zoneDao.getBonus());
			listZones.add(zone);
			
			// On ajoute les adjacences pour chaque région
			for(RegionBean region : listRegions) {
				// On récupère le noeud d'adjacence correspondant à notre région
				AdjacencyDAO adjaDAO = dao.getAdjacencies().getListAdjacency().stream()
						.filter(adj -> adj.getStart().getRegion().getName().replaceAll("\\s", "").equals(region.getName()))
						.findFirst()
						.orElse(null);
				if(adjaDAO == null)
					continue;
				
				for(EndDAO end : adjaDAO.getEnds().getEndList()) {
					// Récupère la région concernée par l'adjacence
					 RegionBean reg = listRegions.stream()
							.filter(r -> r.getName().equals(end.getRegion().getName().replaceAll("\\s", "")))
							.findFirst()
							.orElse(null);
					 if(reg == null)
						 continue;

					AdjacencyBean adjaBean = new AdjacencyBean(reg);
					// Récupération des moves concernant notre adjacence
					for(MoveDAO move : end.getMoves().getMoves()) {
						adjaBean.addMove(move.getName().replaceAll("\\s", ""));
					}
					region.addRegionAdjacency(adjaBean);
				}
				
				// On test si la région est présente dans cette zone
				boolean verif = zoneDao.getRegions().getListRegion().stream()
				.filter(r -> r.getName().replaceAll("\\s", "").equals(region.getName()))
				.findFirst()
				.isPresent();
				
				if(verif) {
					region.setZone(zone);
					zone.addRegion(region);
				}
			}
		}
	}
	
	/**
	 * @return Les règles de la partie
	 */
	public RuleBean getRule() {
		return rule;
	}
	
	/**
	 * Initialise la liste des joueurs
	 * @param listName Liste des noms de joueur
	 * @return Null si nombre de joueurs incorrect, la liste de joueurs dans le cas contraire
	 */
	public List<PlayerBean> setPlayers(List<String> listName, Integer initial) {
		int nbPlayers = listName.size();
		
		this.rule.setPlayers(nbPlayers);
		this.rule.setInitial(initial);
		
		listPlayers = new ArrayList<>();
		for(int i = 0; i < nbPlayers; i++) {
			PlayerBean playerBean = new PlayerBean(listName.get(i), initial);
			listPlayers.add(playerBean);
		}
		return listPlayers;
	}
	
	public List<RegionBean> getRegions() {
		return this.listRegions;
	}

	/**
	 * @return la liste de zones du jeu
	 */
	public List<ZoneBean> getListZones() {
		return listZones;
	}	
}
