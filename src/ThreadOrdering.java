public class ThreadOrdering  {

    private ObjectVector vector;
    private int[] vectorPrimary;
    private int[] vectorSecondary;
    private  int halfVector;
    public ThreadOrdering(ObjectVector vetor) {
        this.vector = vetor;
        halfVector  = vetor.getVector().length / 2;
        vectorPrimary = insertVector(vetor.getVector(),halfVector);
        vectorSecondary= insertVector(vetor.getVector(),(vetor.getVector().length - halfVector),halfVector);
    }
    public ObjectVector getVetor() {
        return vector;
    }
    public  final Runnable threadPrimary = new Runnable() {
        long startTime = System.currentTimeMillis();
        @Override
        public void run() {
            int[] vetorOrdering = Ordering.BubbleSort(vectorPrimary);
            synchronized (vector){
                vector.setVetor(vetorOrdering,0); ;
            }
            long endTime = System.currentTimeMillis();
            long elapsedTime = endTime - startTime;
            System.out.println("ThreadPrimary "+ elapsedTime + " milisegundos");
        }

    };
    public  final Runnable threadSecondary = new Runnable() {
        long startTime = System.currentTimeMillis();
        @Override
        public void run() {
            int[] vetorOrdering =Ordering.BubbleSort(vectorSecondary);
            synchronized (vector){
                vector.setVetor(vetorOrdering,halfVector);
            }
            long endTime = System.currentTimeMillis();
            long elapsedTime = endTime - startTime;
            System.out.println("ThreadSecondary "+ elapsedTime + " milisegundos");
        }

    };

    private int[] insertVector(int[] vetorNew,int size){
        int[] aux = new int[size];
        for(int i = 0; i < size; i++) {
            aux[i] = vetorNew[i];
        }
        return aux;
    }
    private int[] insertVector(int[] vetorNew,int size,int position){
        int[] aux = new int[size];
        for(int i = 0; i < size; i++) {
            aux[i] = vetorNew[position];
            position++;
        }
        return aux;
    }


}
