public class Main
{
    public static void main(String[] args)
    {
        Flower flower = new Flower("Marigold", 12.50);
        flower.setName("Marigold");
        Customer customer = new Customer("Pencho", 250.50);
        customer.subtractAmount(flower.getPrice());
        System.out.println(customer.getBalance());
        FlowerStore store = new FlowerStore("Danny's flowers", 0);
        store.setFlowers(flower, 0, 0);
        store.setFlowers(new Flower("Dandelion", 10), 0, 1);
        store.setFlowers(new Flower("Daffodil", 13), 0, 2);
    }
}
