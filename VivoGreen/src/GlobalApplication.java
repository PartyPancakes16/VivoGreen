import java.util.ArrayList;
import java.util.List;
public class GlobalApplication {
    public static int dimdb=0,countdb=0;
    public static String valori[][];
    
    public static final void setValori(int v)
    {
        dimdb=v;
        valori = new String[dimdb][5];
    }
    public static final void setProdotto(String rf,String de,String pr,String pe,String d)
    {
        valori[countdb][0]=rf;
        valori[countdb][1]=de;
        valori[countdb][2]=pr;
        valori[countdb][3]=pe;
        valori[countdb][4]=d;
        countdb++;
    }
    public static final String getProdotto(int i,int j)
    {
        return valori[i][j];
    }
    public static final int getDimDB()
    {
        return dimdb;
    }
}
