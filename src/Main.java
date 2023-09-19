
import java.util.Scanner;

public  class Main {
    public static void main(String[] args) {
        InitializeApp();
    }

    public static void InitializeApp(){
        Scanner scanner = new Scanner(System.in);
        boolean opcao = true;
        int size=0;
        while (opcao){
            System.out.print("Informe o tamanho do vetor: ");
            size = scanner.nextInt();
            if(size<=0){
                System.out.println( "numero invalido");
            }else{
                opcao = false;
            }
        }


        ObjectVector vetor = new ObjectVector(size);
        //System.out.println("Vetor gerado");
        //ObjectVector.ImprimeVetor(vetor.getVetor());
        long startTime = System.currentTimeMillis();
        int[] vectorOrdingBubleSort = Ordering.BubbleSort(vetor.getVector());
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        System.out.println("SingleThread "+ elapsedTime + " milisegundos");
        System.out.println("Vetor ordenado ");
        ObjectVector.ImprimeVetor(vectorOrdingBubleSort);

        ThreadOrdering threadOrdering = new ThreadOrdering(vetor);
        new Thread(threadOrdering.threadPrimary).start();
        new Thread(threadOrdering.threadSecondary).start();

        System.out.println("Vetor ordenado por 2 thread");
        ObjectVector.ImprimeVetor(threadOrdering.getVetor().getVector());
    }
}


