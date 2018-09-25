var str = "have a nice day"

var split_str = str.split(" ")
console.log(split_str)
new_str = split_str.join("")
console.log(new_str)
len = new_str.length
mat_size = Math.sqrt(len)
rows= Math.floor(mat_size)
cols= Math.ceil(mat_size)

console.log(cols)
console.log(rows)


var c = matrix(cols,rows,new_str)
console.log(c)
var d = flatten_array_cols(c)
console.log(d)
var encrypt_string = d.join("")
console.log(encrypt_string)
var final_string = string_mapper(str, encrypt_string)
console.log(final_string)
var final_final = final_string.join('')
console.log(final_final)

function matrix( rows, cols, str){

  var arr = [];
  var counter = 0

  // Creates all lines:
  for(var i=0; i < rows; i++){

      // Creates an empty line
      arr.push([]);

      // Adds cols to the empty line:
      arr[i].push( new Array(cols));

      for(var j=0; j < cols; j++){
        // Initializes:
        arr[i][j] = str.slice(counter,counter+1);
        counter ++

      }
  }

return arr;
}



function flatten_array_cols(arr)
{
    var arr1=[]
    for(var i=0; i < rows; i++)
    {
         for(var j=0; j < cols; j++)
         {
              arr1.push(arr[j][i])
             
         }
    }    
    return arr1;

}
    

function string_mapper(org_str, enr_str)
{
    arr_en_string= []
    var flag =0
    org_str.split('').forEach(function(i) {
    //[...org_str].forEach(i => 
        if (i !=" ")
        {
          //console.log(i)
            arr_en_string.push(enr_str[flag])
            flag ++
            
        }
        else
        {
            //console.log("")
            arr_en_string.push(' ')
            //flag --
        }
    });
    
    return arr_en_string
}
