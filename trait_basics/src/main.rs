
// デカルト座標
struct CartesianCoord {
    x: f64,
    y: f64,
}

// 極座標
struct PolarCoord {
    r: f64,
    theta: f64,
}

// トレイトを定義する

// 座標
trait Coordinates {
    // 関数の本体は書かない
    fn to_cartesian(self) -> CartesianCoord;
    fn from_cartesian(cart: CartesianCoord) -> Self;
}

// トレイトをそれぞれの型に実装する

// デカルト座標はそのまま
impl Coordinates for CartesianCoord {
    fn to_cartesian(self) -> CartesianCoord {
        self
    }
    fn from_cartesian(cart: CartesianCoord) -> Self {
        cart
    }
}

// 極座標は変換が必要
impl Coordinates for PolarCoord {
    fn to_cartesian(self) -> CartesianCoord {
        CartesianCoord {
            x: self.r * self.theta.cos(),
            y: self.r * self.theta.sin(),
        }
    }
    fn from_cartesian(cart: CartesianCoord) -> Self {
        PolarCoord {
            r: (cart.x * cart.x + cart.y * cart.y).sqrt(),
            theta: (cart.y / cart.x).atan(),
        }
    }
}

// タプルにもトレイトを実装できる
impl Coordinates for (f64, f64) {
    fn to_cartesian(self) -> CartesianCoord {
        CartesianCoord {
            x: self.0,
            y: self.1,
        }
    }
    fn from_cartesian(cart: CartesianCoord) -> Self {
        (cart.x, cart.y)
    }
}

fn main() {
    // 値を用意する
    let point = (1.0, 1.0);

    // トレイとのメソッドを呼ぶ
    let c = point.to_cartesian();
    println!("x = {}, y = {}", c.x, c.y);

    // 同じくトレイとの関連関数を呼ぶ
    let p = PolarCoord::from_cartesian(c);
    println!("r = {}, 0 = {}", p.r, p.theta);
}
