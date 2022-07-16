import sys, pygame
from pygame.locals import *
from random import randrange

class Weight(pygame.sprite.Sprite):

    def __init__(self, speed):
        pygame.sprite.Sprite.__init__(self)
        self.speed = speed
        # スプライト描画に使う画像と長方形
        self.image = weight_image
        self.rect = self.image.get_rect()
        self.reset()

    def reset(self):
        """
        画面最上部のランダムな位置にウェイトを移動する
        """
        self.rect.top = -self.rect.height
        self.rect.centerx = randrange(screen_size[0])
    
    def update(self):
        """
        次のフレームでの表示用にウェイトを更新する
        """
        self.rect.top += self.speed
        if self.rect.top > screen_size[1]:
            self.reset()

# 全体の初期化
pygame.init()
screen_size = 800, 600
pygame.display.set_mode(screen_size, FULLSCREEN)
pygame.mouse.set_visible(0)

# ウェイトの画像の読み込み
weight_image = pygame.image.load('Chapter27/weight.png')
weight_image = weight_image.convert()    # ... ディスプレイに合わせる

# もちろんスピードは自由に変えてかまいません
speed = 5

# スプライトグループを生成し、Weightをそこに付加する
sprites = pygame.sprite.RenderUpdates()
sprites.add(Weight(speed))

# 画面全体を表すサーフェスを取得して塗りつぶす
screen = pygame.display.get_surface()
bg = (255, 255, 255)    # 白
screen.fill(bg)
pygame.display.flip()

# スプライト消去用
def clear_callback(surf, rect):
    surf.fill(bg, rect)

while True:
    # 終了イベントのチェック
    for event in pygame.event.get():
        if event.type == QUIT:
            sys.exit()
        if event.type == KEYDOWN and event.key == K_ESCAPE:
            sys.exit()
    # 前の位置の消去
    sprites.clear(screen, clear_callback)
    # 全スプライトの更新
    sprites.update()
    # 全スプライトの描画
    updates = sprites.draw(screen)
    # 表示の更新(必要な更新部分のみ)
    pygame.display.update(updates)

