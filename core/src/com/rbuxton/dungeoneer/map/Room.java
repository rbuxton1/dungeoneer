package com.rbuxton.dungeoneer.map;

public class Room {
	private boolean u,d,l,r;
	private boolean isBossRoom =false;
	private boolean active = false;
	private RoomMap rMap;
	
	/*
	 * TODO: A lot
	 */
	public Room(){
		rMap = new RoomMap();
	}
	
	public boolean isUpHall(){ return u; }
	public boolean isDownHall(){ return d; }
	public boolean isLeftHall(){ return l; }
	public boolean isRightHall(){ return r; }
	public boolean isBossRoom(){ return isBossRoom; }
	public boolean isConnected(){ return u || d || l || r; }
	public boolean isActive(){ return active; }
	
	public void setUpHall(boolean b){ u = b; }
	public void setDownHall(boolean b){ d = b; }
	public void setLeftHall(boolean b){ l = b; }
	public void setRightHall(boolean b){ r = b; }
	public void setBossRoom(boolean b){ isBossRoom = b; }
	public void setActiveRoom(boolean b){ active = b; }
}
