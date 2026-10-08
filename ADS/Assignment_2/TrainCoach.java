class Train{
    static class Coach{
        private String id;
        private String type;
        private Coach next;

        public Coach(){
        id="";
        type="";
        next=null;
        
    }
    public Coach(String id,String type){
        this.id=id;
        this.type=type;
        next=null;
    }
    }
    private Coach head;
    private Coach tail;
    private int count;

    public Train(){
        head=new Coach("ENGINE","ENGINE");
        tail=head;
        count=0;
    }

    //display
    void display(){
        System.out.println("Train: ");
        Coach trav=head;
        while(trav!=null){
            System.out.println(trav.id);
            if(trav.next!=null){
                System.out.println("->");
            }
            trav=trav.next;
        }
        System.out.println();
    }

    //check duplicate id
    boolean isDuplicate(String id){
        Coach trav=head;
        while(trav!=null){
            if(trav.id.equals(id)){
                return true;
            }
            trav=trav.next;
            }
            return false;
    }

    //attach coach at the end
    void attach(String id,String type){
        if(isDuplicate(id)){
            System.out.println("Duplicate coach id: "+id);
            return;
        }
        Coach newCoach=new Coach(id,type);
        tail.next=newCoach;
        tail=newCoach;
        count++;
    }

    boolean insertAfter(String afterId,String id,String type){
        if(isDuplicate(id)){
            System.out.println("Duplicate coach id: "+id);
            return false;
        }
        Coach trav=head;
        while(trav!=null){
            if(trav.id.equals(afterId)){
                Coach newCoach=new Coach(id,type);
                newCoach.next=trav.next;
                trav.next=newCoach;
                if(trav==tail){
                    tail=newCoach;
                }
                count++;
                return true;
            }
            trav=trav.next;
        }
        System.out.println("Coach not found: "+afterId);
        return false;

    }

    //detach coach by Id
    boolean detach(String id){
        if(id.equals("ENGINE")){
            System.out.println("ENGINE cannot be detached");
            return false;
        }
        Coach prev=head;
        //find the node before the coach
        while(prev.next!=null&&!prev.next.id.equals(id)){
            prev=prev.next;
        }
        //coach not found
        if(prev.next==null){
            System.out.println("Coach not found: "+id);
            return false;
        }

        //coach which has to be deleted
        Coach temp=prev.next;
        if(temp==tail){
            tail=prev;
        }
        //remove coach
        prev.next=temp.next;
        count--;
        return true;
    }

    //FIND POSITiON OF COACH
    int position(String id){
        Coach trav=head.next;
        int pos=1;
        while(trav!=null){
            if(trav.id.equals(id)){
                return pos;
            }
            trav=trav.next;
            pos++;
        }
        return -1;
    }

    //count coaches by type
    int countType(String type){
        int total=0;
        Coach trav=head.next;
        while(trav!=null){
            if(trav.type.equals(type)){
                total++;
            }
            trav=trav.next;
        }
        return total;
    }

    //total coach
    int totalCoaches(){
        return count;
    }

    //reverse coaches
    //ENGINE NUST REMAIN FIRST
    void reverseCoaches(){
        if(head.next==null||head.next.next==null){
            return;
        }
        Coach oldFirst=head.next;
        Coach prev=null;
        Coach curr=head.next;
        while(curr!=null){
            Coach next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        head.next=prev;
        tail=oldFirst;
    }
}

//MAIN CLASS
public class TrainCoach{
    public static void main(String[] args) {
        Train train=new Train();
            train.attach("S1","SLEEPER");
            train.attach("S2","SLEEPER");
            train.attach("S3","SLEEPER");
            train.attach("GEN1","GENERAL");

            train.insertAfter("S2", "PC", "PANTRY");
            train.detach("S3");
            train.display();
            System.out.println("totalCoaches()->"+train.totalCoaches());
            System.out.println("\nAfter reverse: ");
            train.reverseCoaches();
            train.display();
        }
    }

