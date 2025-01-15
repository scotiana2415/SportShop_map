import java.util.*;

public class Controller {
    private Repository<Produkt> produktRepo;
    private Repository<Kunde> kundeRepo;

    public Controller(Repository<Produkt> produktRepo, Repository<Kunde> kundeRepo) {
        this.produktRepo = produktRepo;
        this.kundeRepo = kundeRepo;
    }

    public void addProdukt(Produkt produkt) {
        produktRepo.add(produkt);
    }

    public void addKunde(Kunde kunde) {
        kundeRepo.add(kunde);
    }

    public Produkt getProdukt(int id) {
        return produktRepo.get(id);
    }

    public Kunde getKunde(int id) {
        return kundeRepo.get(id);
    }

    public void deleteProdukt(int id) {
        produktRepo.delete(id);
    }

    public void deleteKunde(int id) {
        kundeRepo.delete(id);
    }

    public void updateProdukt(int id, Produkt produkt) {
        produktRepo.update(id, produkt);
    }

    public void updateKunde(int id, Kunde kunde) {
        kundeRepo.update(id, kunde);
    }

    public void filterNachOrt(String ort) {
        Map<Integer, Kunde> kundeMap = kundeRepo.getAll();
        List<Map.Entry<Integer, Kunde>> filteredKundeMap = new ArrayList<>();
        for(Map.Entry<Integer, Kunde> entry : kundeMap.entrySet()) {
            if(entry.getValue().getOrt().equals(ort)) {
                filteredKundeMap.add(entry);
            }
        }

        for(Map.Entry<Integer, Kunde> entry : filteredKundeMap) {
            System.out.println(entry.getValue().getId() + ", " + entry.getValue().getName());
        }
    }

    public void filterNachJahrzeit(Jahreszeit jahrzeit) {
        Map<Integer, Kunde> kundeMap = kundeRepo.getAll();

        List<Map.Entry<Integer, Kunde>> filteredKundeMap = new ArrayList<>();
        for(Map.Entry<Integer, Kunde> entry : kundeMap.entrySet()) {
            for(Produkt produkt : entry.getValue().getProduktList()) {
                if(produkt.getJahreszeit().equals(jahrzeit)) {
                    filteredKundeMap.add(entry);
                }
            }
        }

        for(Map.Entry<Integer, Kunde> entry : filteredKundeMap) {
            System.out.println(entry.getValue().getId() + ", " + entry.getValue().getName());
        }
    }

    public void sortiereNachProdukte(int kundeId, String modus) {
        Kunde kunde = kundeRepo.get(kundeId);

        List<Produkt> filteredProdukt = new ArrayList<>();

        if(modus.equals("asc"))
            filteredProdukt = kunde.getProduktList().stream().sorted(Comparator.comparing(Produkt::getName)).toList();
        else if(modus.equals("desc"))
            filteredProdukt = kunde.getProduktList().stream().sorted(Comparator.comparing(Produkt::getName)).toList().reversed();

        for(Produkt produkt : filteredProdukt) {
            System.out.println(produkt.getName() + ", " + produkt.getJahreszeit());
        }
    }
}
