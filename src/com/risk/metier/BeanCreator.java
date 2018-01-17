package com.risk.metier;

import java.util.ArrayList;
import java.util.List;

import com.risk.beans.AdjacencyBean;
import com.risk.beans.PlayerBean;
import com.risk.beans.RegionBean;
import com.risk.dao.AdjacencyDAO;
import com.risk.dao.EndDAO;
import com.risk.dao.MapDAO;
import com.risk.dao.ModeDAO;
import com.risk.dao.MoveDAO;
import com.risk.dao.RegionDAO;

/**
 * 
 * @author Giraud
 * Objet de création, gestion des beans
 */
public class BeanCreator {
	private MapDAO dao;
	private List<PlayerBean> listPlayers;
	private List<RegionBean> listRegions;
	
	public BeanCreator(MapDAO mapDao) {
		this.dao = mapDao;
		
		
		for(RegionDAO regionDao : dao.getRegions().getListRegion()) {
			RegionBean region = new RegionBean(regionDao.getName(), regionDao.getBonus());
			listRegions.add(region);
		}
		
		for(RegionBean region : listRegions) {
			AdjacencyDAO adjaDAO = dao.getAdjacencies().getListAdjacency().stream()
					.filter(adj -> adj.getStart().getRegion().getName() == region.getName()).findFirst().get();
			
			for(EndDAO end : adjaDAO.getEnds().getEndList()) {
				RegionBean reg = listRegions.stream().filter(r -> r.getName() == end.getRegion().getName()).findFirst().get();
				AdjacencyBean adjaBean = new AdjacencyBean(reg);
				for(MoveDAO move : end.getMoves().getMoves()) {
					adjaBean.addMove(move.getName());
				}
				reg.addRegionAdjacency(adjaBean);
			}
		}
		
	}
	
	/**
	 * Initialise la liste des joueurs
	 * @param listName Liste des noms de joueur
	 * @return Null si nombre de joueurs incorrect, la liste de joueurs dans le cas contraire
	 */
	public List<PlayerBean> setPlayers(List<String> listName) {
		int nbPlayers = listName.size();
		int initial = -1;
		
		// On récupère les données de la DAO afin de savoir notre nombre initial selon le nombre de joueurs dans la partie
		for(ModeDAO mode : dao.getModes().getModes()) {
			if (mode.getPlayers() == nbPlayers) {
				initial = mode.getInitial();
				break;
			}
		}
		
		if(initial == -1)
			return null;
		
		listPlayers = new ArrayList<>();
		for(int i = 0; i < nbPlayers; i++) {
			PlayerBean playerBean = new PlayerBean(listName.get(i), initial);
			listPlayers.add(playerBean);
		}
		return listPlayers;
	}
	
	
}
