def print_params_2(title, *params):
    print(title)
    print(params)

print_params_2('引数:', 1, 2, 3)
print_params_2('引数はこれだけ:')


print_params_2('Hmm...', something=42)
