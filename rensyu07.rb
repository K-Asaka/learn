def get_local_and_domain(str)
    str =~ /^([^@]+)@(.*)$/
    localpart = $1
    domain = $2
    return [localpart, domain]
end

p get_local_and_domain("info@example.com")

p "正規表現は難しい！ なんて難しいんだ！".gsub(/難しいんだ/, "簡単なんだ").gsub(/難しい/, "簡単だ")

def word_capitalize(str)
    return str.split(/\-/).collect{|w| w.capitalize}.join('-')
end

p word_capitalize("in-reply-to")
p word_capitalize("X-MAILER")
