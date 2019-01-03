array = ["Ruby", "Perl", "PHP", "Python"]
sorted = array.sort{ |a, b| b.length <=> a.length }
p sorted
