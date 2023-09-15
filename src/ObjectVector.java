import java.util.Arrays;

public class ObjectVector {

    private  int[] vector;

    public ObjectVector(int size){
        vector = new int[size];
        for (int i = 0; i < size; i++) {
            vector[i] = size - i;
        }
    }

    public int[] getVector() {
        return vector;
    }

    public void setVetor(int[] vetorNew, int position) {
        for (int i = 0; i < vetorNew.length && (position + i) < vector.length; i++) {
            this.vector[position + i] = vetorNew[i];
        }
    }

    public static void ImprimeVetor(int[] vetor){
        String arrayString = Arrays.toString(vetor)
                .replace(",", "");
        System.out.println(arrayString);
    }

}
