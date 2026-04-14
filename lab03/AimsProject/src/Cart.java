public class Cart {
    public static  final  int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc itemOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];

    int qtyOrdered(){
        int count=0;
        for(int i=0;i<MAX_NUMBERS_ORDERED;i++){
            if(itemOrdered[i]!= null){
                count++;
            }
        }
        return count;
    }
    void addDigitalVideoDisc(DigitalVideoDisc disc){
        int disNumber= qtyOrdered();
        System.out.println(disNumber);
        if(disNumber>=20){
            System.out.print("The cart is almost full");
            return;
        }
        itemOrdered[disNumber]= disc;

        System.out.println("The disc has been added");
    }
    void addDigitalVideoDisc(DigitalVideoDisc[] dvdlist){
        int disNumber= qtyOrdered();
        int currentDvdIndex= 0;
        while(currentDvdIndex < dvdlist.length){
            if(disNumber>=20){
                System.out.print("The cart is almost full");
                break;
            }
            itemOrdered[disNumber]= dvdlist[currentDvdIndex];
            currentDvdIndex++;
            disNumber++;
            System.out.print("The" + currentDvdIndex+ " disc has been added");

        }
    }
    void addDigitalVideoDisc(DigitalVideoDisc dvd1,DigitalVideoDisc dvd2){
        int disNumber= qtyOrdered();
        if(disNumber>=20){
            System.out.print("The cart is almost full");
            return;
        }
        itemOrdered[disNumber]= dvd1;
        disNumber++;
        if(disNumber>=20){
            System.out.print("The cart is almost full");
            return;
        }
        itemOrdered[disNumber]= dvd2;
        System.out.print("The 2 disc has been added");
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
    float totalCost(){
        float total=0;
        for(int i=0;i<qtyOrdered();i++){
            total+=itemOrdered[i].getCost();
        }
        return total;
    }
    public void PrintList(){
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        float totalCost= 0f;
        for(int i=0; i< qtyOrdered(); i++){
            System.out.println(itemOrdered[i].toString());
        }
        System.out.println("Total cost: "+totalCost());
        System.out.println("***************************************************");
    }

}
