package activities

// Two-Pointer Method
class Solution{
  def removeDuplicates(nums: Array[Int]): Int = {
    var i = 0  // Counter
    if (nums.isEmpty) return 0
    for(j <- 1 until nums.length) {
      if(nums(i) != nums(j)) {
        i += 1;
        nums(i) = nums(j)
      }
    }
    i+1
  }
}

object RemoveDuplicatesFromSortedArray extends App{
  var solution = new Solution()
  println(solution.removeDuplicates(Array(1,2,2,3,4,5,5,6,6,6,8)))
}

