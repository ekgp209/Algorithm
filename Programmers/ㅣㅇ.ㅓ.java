long[] arr = new long[2];
        
    try{
    if(n > m){ 
        long res = n%m;
        long max_num; //최소공배수
        
        if(m%res == 0){
            //최대공약수 res
            max_num = (n*m)/res;

            arr[0] = res;
            arr[1] = max_num;

        }else{
            //서로소
            arr[0] = 1;
            arr[1] = n*m;
        }
    }
    else if (m > n){
        long res = m%n;
        long max_num; //최소공배수
        
        if(n%res == 0){
            //최대공약수 res
            max_num = (n*m)/res;
            
            arr[0] = res;
            arr[1] = max_num;
        }else{
            //서로소
            arr[0] = 1;
            arr[1] = n*m;
        }
    }else{
        arr[0] = 1;
        arr[1] = n;
    }
    }catch(ArithmeticException e){
        if(n>m){
            arr[0] = m;
            arr[1] = n;
        }else{
            arr[0] = n;
            arr[1] = m;
        }
    }
