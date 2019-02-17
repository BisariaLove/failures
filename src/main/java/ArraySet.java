public class ArraySet<T> {

    T[] arrayElements;
    int size;

    public ArraySet(){
        arrayElements = null; // set allows null
        size = 0;
    }

    public ArraySet(T[] array){

        arrayElements  = array;
        size = array.length;
    }

    public boolean contains(T element){

        //if the element is null
        if(element == null){
            for(int i = 0; i<size ; i++){
                if(arrayElements[i] == null){
                    return true;
                }
            }
        } else{ // if the element is not-null
            for(int i = 0 ; i<size ; i++){
                if(arrayElements[i].equals(element)){
                    return true;
                }
            }
        }

        return false;
    }

    public void addElement(T element){
        if(contains(element)){
            return;
        }

        if(arrayElements.length == size){
            increaseArraySize();
        }

        arrayElements[size++] = element;
    }

    public void clear(){
        arrayElements = null;
    }

    public void increaseArraySize(){
        T[] tempArray = arrayElements;
        int tempSize = size + 5;
        arrayElements = (T[])new Object[tempSize];
        System.arraycopy(tempArray, 0, arrayElements,0, size);
    }

    public boolean isEmpty(){

        if(arrayElements == null || arrayElements.length == 0){
            return true;
        }else{
            return false;
        }
    }

    public void printSet(){

        for(int i=0 ; i<size ; i ++){
            System.out.print(arrayElements[i] + "  ");
        }
    }


    public static void main(String[] args){
        String[] array = new String[]{"hello", "world"};


        ArraySet set = new ArraySet(array);

        System.out.println(set.contains("hello"));

        set.addElement("Hello");

        set.printSet();

    }
}
