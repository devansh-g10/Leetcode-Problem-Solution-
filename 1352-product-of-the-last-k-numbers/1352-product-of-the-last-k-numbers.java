class ProductOfNumbers {
    private int[] list;
    private int size;

    public ProductOfNumbers() {
        list = new int[16];
        list[0] = 1;
        size = 1;
    }
    
    public void add(int num) {
        if(num == 0 ) {
            size = 1;
            list[0] = 1;
        }
        else {
            if(size == list.length) {
                list = Arrays.copyOf(list,size*2);
            }
            list[size] =  list[size-1] * num;
            size++;
        }

    }
    
    public int getProduct(int k) {

        if(k >= size ) {
            return  0;
        }
        return list[size-1] / list[size-1-k];
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */