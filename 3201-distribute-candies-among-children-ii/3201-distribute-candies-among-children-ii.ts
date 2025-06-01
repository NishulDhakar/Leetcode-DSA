function distributeCandies(n: number, limit: number): number {

    let res = 0;
    let firstmin = Math.max(0, n - 2*limit);
    let firstmax = Math.min(limit, n);

    for(let a = firstmin ; a <= firstmax ; a++){

        let remaining = n - a;

        let bmin = Math.max(0,remaining -limit);
        let bmax = Math.min(limit , remaining);

        res += bmax - bmin + 1;
    }
    return res;
};