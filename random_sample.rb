r1 = Random.new(1)
p [r1.rand, r1.rand]
r2 = Random.new(1)
p [r2.rand, r2.rand]

r3 = Random.new
p [r3.rand, r3.rand]
r4 = Random.new
p [r4.rand, r4.rand]

require "securerandom"
p SecureRandom.random_bytes(12)
p SecureRandom.base64(12)
