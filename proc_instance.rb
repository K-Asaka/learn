prc = Proc.new{|a, b| a + b }
p prc.call(1, 2)
p prc[3, 4]
p prc.yield(5, 6)
p prc.(7, 8)
p prc === [9, 10]

fizz = proc{|n| n % 3 == 0 }
buzz = proc{|n| n % 5 == 0 }
fizzbuzz = proc{|n| fizz[n] && buzz[n] }
(1..100).each do |i|
    case i
    when fizzbuzz then puts "Fizz Buzz"
    when fizz then puts "Fizz"
    when buzz then puts "Buzz"
    else puts i
    end
end

prc0 = Proc.new{ nil }
prc1 = Proc.new{|a| a }
prc2 = Proc.new{|a, b| a + b }
prc3 = Proc.new{|a, b, c| a + b + c }
prcn = Proc.new{|*args| args }

p prc0.arity
p prc1.arity
p prc2.arity
p prc3.arity
p prcn.arity

prc0 = proc{ nil }
prc1 = proc{|a| a }
prc2 = lambda{|a, b| [a, b] }
prc3 = lambda{|a, b=1, *c| [a, b, c] }
prc4 = lambda{|a, &block| [a, block] }
prc5 = lambda{|a: 1, **b| [a, b] }

p prc0.parameters
p prc1.parameters
p prc2.parameters
p prc3.parameters
p prc4.parameters
p prc5.parameters

prc1 = Proc.new{|a, b| a + b }
p prc1.lambda?

prc2 = lambda{|a, b| a + b }
p prc2.lambda?


prc0 = Proc.new{ nil }
prc1 = Proc.new{|a| a }

p prc0.source_location
p prc1.source_location
