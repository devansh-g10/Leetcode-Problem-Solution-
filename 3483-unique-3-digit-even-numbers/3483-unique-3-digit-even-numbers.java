class Solution {
    public int totalNumbers(int[] digits) {
        List<Integer> result = new ArrayList<>();
        int[] freq = new int[10];
        for (int digit : digits) {
            freq[digit]++;
        }

        for (int i = 1; i <= 9; i++) {
            if (freq[i] == 0) continue;
            freq[i]--;

            for (int j = 0; j <= 9; j++) {
                if (freq[j] == 0) continue;
                freq[j]--;

                for (int k = 0; k <= 8; k += 2) { 
                    if (freq[k] == 0) continue;
                    freq[k]--;

                    int num = i * 100 + j * 10 + k;
                    result.add(num);

                    freq[k]++;
                }

                freq[j]++;
            }

            freq[i]++;
        }
        // int[] resArr = new int[result.size()];
        // int count = 0;
        // for (int i = 0; i < result.size(); i++) {
        //     resArr[i] = result.get(i);
        //     count++;
        // }

        return result.size();
    }
}