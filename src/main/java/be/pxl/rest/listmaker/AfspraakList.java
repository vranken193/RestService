package be.pxl.rest.listmaker;

import be.pxl.rest.domain.Afspraak;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

@XmlRootElement
public class AfspraakList implements Serializable {
    private List<Afspraak> afspraakList;

    public AfspraakList(){

    }

    public AfspraakList (List<Afspraak> afspraakList){
        this.afspraakList = afspraakList;
    }

    public List<Afspraak> GetAfspraakList(){
        return afspraakList;
    }

    public void SetAfspraakList(List<Afspraak> afspraakList){
        this.afspraakList = afspraakList;
    }


}
