class Solve {
    int[] findTwoElement(int arr[], int n) {
        // code here
        int repeating=0, missing =0; // initialised the elements to be returned
        for(int i=0; i<n; i++){
            int ind = Math.abs(arr[i])-1;
            if(arr[ind] > 0){
                arr[ind] = -arr[ind];
            }
            else{
                repeating = Math.abs(arr[i]);
            }
        }
        for(int i=0; i<n; i++){
            if(arr[i] > 0){
                missing = i+1;
                break;
            }
        }
        return new int[]{repeating, missing};
    }
}
