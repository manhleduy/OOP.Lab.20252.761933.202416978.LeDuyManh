public class Store {
    private int MAX_DVD_CONTAIN= 100;
    private DigitalVideoDisc itemsInStore[]= new DigitalVideoDisc[MAX_DVD_CONTAIN];
    int DVDStored(){
        int count=0;
        for(int i=0;i<MAX_DVD_CONTAIN;i++){
            if(itemsInStore[i]!= null){
                count++;
            }
        }
        return count;
    }
    public void addDVD(DigitalVideoDisc dvd){
        int dvdstored= DVDStored();
        if(dvdstored>=100){
            System.out.println("Storage is full");
            return;
        }
        itemsInStore[dvdstored]= dvd;
    }
    public void removeDVD(DigitalVideoDisc dvd){
        int count= DVDStored();
        for(int i=0;i<count;i++){
            if(itemsInStore[i]==dvd){
                for(int j=i;j<count-1;j++){
                    itemsInStore[j]= itemsInStore[j+1];
                }
                itemsInStore[count-1]=null;

                System.out.print("the disc has been removed");
                return;
            }
        }
        System.out.print("Nor found");
    }
}
