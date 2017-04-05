package com.rbuxton.dungeoneer.map;

public class Room {
	private boolean u,d,l,r;
	private boolean isBossRoom;
	private int numConnect = 0;
	
	public Room(){
		
	}
	
	public boolean isUpHall(){ return u; }
	public boolean isDownHall(){ return d; }
	public boolean isLeftHall(){ return l; }
	public boolean isRightHall(){ return r; }
	public boolean isBossRoom(){ return isBossRoom; }
	
	public void setUpHall(boolean b){ u = b; }
	public void setDownHall(boolean b){ d = b; }
	public void setLeftHall(boolean b){ l = b; }
	public void setRightHall(boolean b){ r = b; }
	public void setBossRoom(boolean b){ isBossRoom = b; }
}