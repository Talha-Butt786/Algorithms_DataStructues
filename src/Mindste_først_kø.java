public class Mindste_først_kø {
    int addPointer; //points to the position where new number is to be added.
    int removePointer; //points tot position of the element, which is to be deleted.
    int sizeofQueue;   //number of elements in the queue.
    int minimumPointer; // points at the position of minimum element.
    int [] array;      //array to store values.

    public Mindste_først_kø(int size){
        addPointer=0;
        removePointer=0;
        sizeofQueue=0;
        array=new int[size+1]; //because addPointer and removePointer cannot point at same index,so in order to create a buffer i.e space of one box or index between them.
    }

    //function to add elements into the queue.
    public void insert(int number) throws Exception{
        //if addPointer point at last position so we have to check whether removePointer points at 0 position or not before adding an element at the last position,to maintain a space between the pointers.
        if(addPointer==array.length-1){
            if(addPointer+1-array.length==removePointer){
                throw new Exception("Cannot enqueue, Queue is full");
            }
            array[addPointer]=number;
            if(array[minimumPointer]>number)minimumPointer = addPointer;
            sizeofQueue++;
            addPointer=0;
        }
        else{
            if(addPointer+1==removePointer){
                throw new Exception("Cannot enqueue, Queue is full");
            }
            array[addPointer]=number;
            if(array[minimumPointer]>number)minimumPointer = addPointer;
            sizeofQueue++;
            addPointer++;
        }
    }

    //function to delete elements from the queue.
    public int extract(){
        if(sizeofQueue==0){
            return 0;
        }
        if(removePointer==array.length-1){
            removePointer=0;
        }
        sizeofQueue--;
        removePointer++;
        return array[removePointer-1];
    }

    //function to check is queue empty?
    public boolean isempty(){
        if(sizeofQueue==0){
            return true;
        }
        return false;
    }
    public int [] getArray(){
        return array;
    }
}
