class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {

        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);

        int maxUnitBoxes = 0;

        for (int i = 0; i < boxTypes.length; i++) {
            int boxCount = boxTypes[i][0];
            int unitsPerBox = boxTypes[i][1];

            if (truckSize >= boxCount) {
                maxUnitBoxes += boxCount * unitsPerBox;
                truckSize -= boxCount;
            } else {
                maxUnitBoxes += truckSize * unitsPerBox;
                break;
            }
        }

        return maxUnitBoxes;
    }
}
