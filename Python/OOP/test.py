characters = 'ABCDE'
codes = list(filter(lambda character: character > 66, map(ord, characters)))
print(codes) # 67, 68, 69]

characters = 'ABCDE'
codes = [ord(character) for character in characters if ord(character) > 66]
print(codes) # 67, 68, 69]
