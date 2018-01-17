package com.risk.metier;

import java.util.ArrayList;
import java.util.List;

import com.risk.beans.PlayerBean;
import com.risk.beans.RegionBean;
import com.risk.dao.MapDAO;

public class BeanCreator {
	private MapDAO dao;
	private List<PlayerBean> listPlayers;
	private List<RegionBean> listRegions;
	
	public BeanCreator(MapDAO mapDao) {
		this.dao = mapDao;
	}
	
	/**
	 * Pas finis j'suis allé mangé mais je commit pour que tu puisses l'utiliser comme si walla quoi
	 * @param listName
	 * @return
	 */
	public List<PlayerBean> setPlayers(ArrayList<String> listName) {
		int nbPlayers = listName.size();
		int initial = 0; // TODO enlever
		switch(nbPlayers) { // TODO A reflechir paskeu pabi1
			case 2:
				initial = dao.getModes().getModes().get(0).getInitial();
				break;
		}
		listPlayers = new ArrayList<>();
		for(int i = 0; i < nbPlayers; i++) {
			PlayerBean playerBean = new PlayerBean(listName.get(i), initial);
		}
		return listPlayers;
	}
	
	
}
