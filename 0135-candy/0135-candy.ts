function candy(ratings: number[]): number {
    
    let n = ratings.length;
    let c = new Array(n).fill(1);
    let sum = 0;

    for(let i = 1 ; i < n ; i++){
        if(ratings[i] > ratings[i-1]){
            c[i] = c[i-1] + 1
        }
    }

    for(let i = n-2 ; i >= 0 ; i--){
        if(ratings[i] > ratings[i+1]){
            c[i] = Math.max(c[i] ,c[i] = c[i+1] + 1)
        }
    }

    sum = c.reduce((a ,b) => a + b , 0)

    return sum;
};