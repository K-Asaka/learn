
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

// トレイト境界の指定方法
// fn print_point<P: Coordinates>(point: P) {   // 1
// fn print_point<point: impl Coordinates) {    // 2
fn print_point<P>(point: P)                     // 3
where
    P: Coordinates,
{
    let p = point.to_cartesian();
    println!("({}, {})", p.x, p.y)
}

// PにCoordinatesとCloneの2つの境界を付ける
fn as_cartesian<P: Coordinates + Clone>(point: &P) -> CartesianCoord {
    point.clone().to_cartesian()
}

// Pを2回書くには型パラメータが必要
fn double_point<P: Coordinates>(point: P) -> P {
    let mut cart = point.to_cartesian();
    cart.x *= 2.0;
    cart.y *= 2.0;
    P::from_cartesian(cart)
}

// (T, T)のようにTそのものでない型への制約はジェネリクスが必要
fn make_point<T>(x: T, y: T) -> CartesianCoord
where
    (T, T): Coordinates
{
    (x, y).to_cartesian()
}

// ジェネリクストレイトを用意しておく
// トレイトもジェネリクスにできる
trait ConvertTo<Output> {
    fn convert(&self) -> Output;
}

fn to<T>(i: i32) -> T
where
    // ConvertTo<T>と型パラメータがトレイト側にある
    // where記法だとi32など具体的な型に制約がかける
    i32: ConvertTo<T>,
{
    i.convert()
}


// 線形変換に必要な行列を定義しておく
struct Matrix([[f64; 2]; 2]);
// 座標に対して線形変換を定義する
trait LinearTransform: Coordinates {
    fn transform(self, matrix: &Matrix) -> Self;
}
// 継承するトレイトをすべて実装しているのでLinearTransformをCartesianCoordに実装できる
impl LinearTransform for CartesianCoord {
    fn transform(mut self, matrix: &Matrix) -> Self {
        let x = self.x;
        let y = self.y;
        let m = matrix.0;

        self.x = m[0][0] * x + m[0][1] * y;
        self.y = m[1][0] * x + m[1][1] * y;
        self
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

    // Coordinatesを実装している型の値は渡せる
    print_point((0.0, 1.0));        // (0, 1)
    print_point(PolarCoord {
        r: 1.0,
        theta: std::f64::consts::PI / 2.0,
    }); // (0.00000000000000006123233995736766, 1)

    // しかしCoordinatesを実装していない型の値を引数に渡そうとするとコンパイルエラーになる
    // print_point("string");


}
