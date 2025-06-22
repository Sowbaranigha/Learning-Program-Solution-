package computer;

public class Main {
    public static void main(String[] args) {

    	//1. gaming computer
        Computer gamingPC = new Computer.Builder()
            .setCPU("Intel i9")
            .setRAM("32GB")
            .setStorage("1TB SSD")
            .setGPU("NVIDIA RTX 4090")
            .build();

        // 2. office computer
        Computer officePC = new Computer.Builder()
            .setCPU("Intel i5")
            .setRAM("16GB")
            .setStorage("512GB SSD")
            .build();

        //3. basic computer
        Computer basicPC = new Computer.Builder()
            .setCPU("AMD Ryzen 3")
            .setRAM("8GB")
            .build();

        // print all
        System.out.println("Gaming PC: " + gamingPC);
        System.out.println("Office PC: " + officePC);
        System.out.println("Basic PC: " + basicPC);
    }
}
