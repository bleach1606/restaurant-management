package bleach;

import DTO.ii;

import java.util.ArrayList;

public class Convert {
    private String key; //[1, 2, 3, 4, 5]

    public Convert() {
    }

    public Convert(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public ArrayList<ii> getListII() {
        ArrayList<ii> list = new ArrayList<>();
        String s = "";
        for(int i = 0; i < key.length(); i++) {
            if(key.charAt(i) == '{') {
                while (key.charAt(i+1) != '}') {
                    i++;
                    if(key.charAt(i) != ' ') s += key.charAt(i);
                }
                String sky[] = s.split(",");
                s = "";
                ii k = new ii();
                k.setX(Integer.parseInt(sky[0]));
                k.setY(Integer.parseInt(sky[1]));
                list.add(k);
            }
        }
        return list;
    }

}
