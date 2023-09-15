public class Ordering {
    public static int[] BubbleSort( int[] vector){
        boolean isOrdered;

        for (int i = 0; i < vector.length; i++){
            isOrdered = false;
            for (int j = 0; j < (vector.length-1); j++){
                if(vector[j] > vector[j+1]){

                    int aux = vector[j];

                    vector[j] = vector[j+1];

                    vector[j+1] = aux;

                    isOrdered = true;
                }
            }
            if (!isOrdered){
                break;
            }

        }

        return  vector;
    }
}
