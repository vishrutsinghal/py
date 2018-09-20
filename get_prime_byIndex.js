function get_prime(num)
{
    // var num = 120
    var flag =0
    var counter = 1
    while (true)
    {
        var flag =0
        while (counter<=num)
            {
                if (num% counter== 0)
                {
                    flag++
                    counter ++
                }
                else
                {
                    counter ++
                }
            }
        if (flag == 2)
            {
                return(num)
            }
        else
        {
            num ++
            counter = 0

        }
        counter ++

    }

}


function is_prime(num)
{
    var arr = [1]

    for (var i = 1; i<=num; i++)
    {
        var last =  function(array, n) {
        if (n == null)
            return array[array.length - 1];
        return array.slice(Math.max(array.length - n, 0));
          };

        var l = last(arr)

        var prime_num=get_prime(l+1)

        arr.push(prime_num)
    }

    var len = arr.length
    console.log(arr[len-1]);
}

is_prime(10)
