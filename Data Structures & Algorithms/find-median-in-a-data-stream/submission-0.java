class MedianFinder {
    ArrayList<Integer> list;

    public MedianFinder() {
        list = new ArrayList<>();
    }
    
    public void addNum(int num) {
        list.add(num);
        Collections.sort(list);
    }
    
    public double findMedian() {
        double result;

        if(list.size() % 2 != 0) {
            int num1 = list.get(list.size() / 2);
            result = (double) num1;
        } else {
            int num1 = list.get(list.size() / 2 - 1);
            int num2 = list.get(list.size() / 2);
            double value = (double)(num1 + num2) / 2;
            result = value;
        }

        return result;
    }
}
