public class Cart {
    public static  final  int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc itemOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    int qtyOrdered(){
        return itemOrdered.length;
    }
    void addDigitalVideoDisc(DigitalVideoDisc disc){
        int disNumber= qtyOrdered();
        if(disNumber>=20){
            System.out.print("The cart is almost full");
            return;
        }
        itemOrdered[disNumber]= disc;
        System.out.print("The disc has been added");
    }


    void removeDigitalVideoDisc(DigitalVideoDisc disc){
        for(int i=0;i<qtyOrdered();i++){
            if(itemOrdered[i]==disc){

                for(int j=i;j<qtyOrdered()-1;i++){
                    itemOrdered[j]= itemOrdered[j+1];
                }
                itemOrdered[qtyOrdered()]=null;
                System.out.print("the disc has been removed");
                return;
            }
        }
        System.out.print("Nor found");
    }
    int totalCost(){
        int total=0;
        for(int i=0;i<qtyOrdered();i++){
            total+=itemOrdered[i].getCost();
        }
        return total;
    }
}
