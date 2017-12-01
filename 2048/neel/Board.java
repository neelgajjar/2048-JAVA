
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;


public class Board {

	private Tile[] myTiles;
	
	public Board() {
		myTiles = new Tile[4 * 4];
		for (int i = 0; i < myTiles.length; i++) {
			myTiles[i] = new Tile();
		}
	}
	
    public Tile[] getLine(int index) {
        Tile[] result = new Tile[4];
        for (int i = 0; i < 4; i++) {
            result[i] = tileAt(i, index);
        }
        return result;
    }
    
    public void setLine(int index, Tile[] re) {
        System.arraycopy(re, 0, myTiles, index * 4, 4);
    }
    
    public Tile[] up_getLine(int index) {
        Tile[] result = new Tile[4];
        for (int i = 0; i < 4; i++) {
            result[i] = tileAt(index,i);
        }
        return result;
    }
    
    public void up_setLine(int index, Tile[] re) {
        for(int i=0;i<4;i++){
            myTiles[(index)+(i*4)].value=re[i].value;
        }    
    }
    
    public Tile[] down_getLine(int index) {
        Tile[] result = new Tile[4];
        for (int i = 0; i < 4; i++) {
            result[i] = tileAt(index,3-i);
        }
        return result;
        }
    
    public void down_setLine(int index, Tile[] re) {
        for(int i=0;i<4;i++){
            myTiles[(index)+(i*4)].value=re[3-i].value;
        }    
    }
    
    public Tile tileAt(int x, int y) {
        return myTiles[x + y * 4];
    }
    
    public List<Tile> availableSpace() {
        final List<Tile> list = new ArrayList<Tile>(16);
        for (Tile t : myTiles) {
            if (t.isEmpty()) {
                list.add(t);
            }
        }
        return list;
    }
    
	public Tile[] getTiles() {
		return myTiles;
	}
	
}
