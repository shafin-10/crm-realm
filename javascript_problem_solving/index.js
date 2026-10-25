//-------------------------------------
//Problem 1: First non-repeating character 
//-------------------------------------

/** Approach - 
 * First, iterate through the string and count each character's frequency in a Map, converting characters to lowercase.
 * Then, iterate through the original string and return the first character whose frequency is exactly one.
 * If no such character exists, return null.
**/ 

/** spaces and functions :
 * Spaces and punctuation are ignored during both counting and searching. Only letters and digits are considered, and uppercase and lowercase letters are treated as the same character while preserving the original case of the returned character.
  */

function firstNonRepeatingChar(str) {
  let count = new Map();

  for (let ch of str) {
     if (!/[a-z0-9]/i.test(ch)) continue;

    let lowerCh = ch.toLowerCase();
    count.set(lowerCh, (count.get(lowerCh) || 0) + 1);
  }

  for (let ch of str) {
    if (!/[a-z0-9]/i.test(ch)) continue;
    let lowerCh = ch.toLowerCase();
    if (count.get(lowerCh) === 1) {
      return ch;
    }
  }
  return null;
}

console.log(firstNonRepeatingChar("aabbcdd"));
console.log(firstNonRepeatingChar("aabb"));
console.log(firstNonRepeatingChar(""));
console.log(firstNonRepeatingChar("AabBc"));


//-------------------------------------
//Problem 2: Find two numbers that add up to a target
//-------------------------------------
/** Approach - 
 * Treat arr[i] as the first element and calculate the required second element, ele2.
 * Check whether ele2 exists in the map. If it does, return the indices of both elements.
 * Otherwise, store the current element and its index in the map.
 * Return null if no valid pair exists.
 
 Complexity: (O(n)) average time and (O(n)) space.
**/ 
function findTwoSum(arr, target) {
    let map = new Map();

    for (let i = 0; i < arr.length; i++) {
        const ele2 = target - arr[i];

        if (map.has(ele2)) {
            return [map.get(ele2), i];
        }

        map.set(arr[i], i);
    }

    return null;
}

console.log(findTwoSum([2, 7, 11, 15], 9)); 


//-------------------------------------
//Problem 3: Count leads by status
//-------------------------------------
/** Approach - 
 * Initialize an empty object to store status counts.
 * Iterate through the leads and increment the count for each status, using 0 as the default count.
 * Return the object without modifying the original array.
 
 

 ***Explain how you would include statuses with a count of zero*** 
 -I would create an object containing all possible statuses, initializing each count to 0. Then, I would iterate through the leads and increment the count for each lead's status.
**/ 
function countLeadsBtStatus(leads){
    let counts = {};

    for(let lead of leads){
        counts[lead.status] = (counts[lead.status] || 0) + 1;
    }

    return counts;
}

const leads1 = [
    { name: "Alice", status: "NEW" },
    { name: "Bob", status: "CONTACTED" },
    { name: "Charlie", status: "NEW" },
    { name: "David", status: "QUALIFIED" }
];
console.log(countLeadsBtStatus(leads1));

const leads2 = [];
console.log(countLeadsBtStatus(leads2));
