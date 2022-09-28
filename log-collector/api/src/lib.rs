use chrono::{DateTime, Utc};
use serde_derive::*;
// JSONの{"user_agent": "xxx", "response_time": 0, "timestamp": "yyyy-MM-dd+HH:mm:ss"}に対応
// 戻り値で使うログはtimestampがOptionではない
#[derive(Debug, Clone, Eq, PartialEq, Hash, Deserialize, Serialize)]
pub struct Log {
    pub user_agent: String,
    pub response_time: i32,
    pub timestamp: DateTime<Utc>,
}

// クエリパラメータの?from=yyyy-MM-dd+HH:mm:ss&until=yyyy-MM-dd+HH:mm:ssに対応
#[derive(Debug, Clone, Eq, PartialEq, Hash, Deserialize, Serialize)]
pub struct DateTimeRange {
    pub from: Option<DateTime<Utc>>,
    pub until: Option<DateTime<Utc>>,
}

pub mod csv {
    pub mod get {
        use crate::DateTimeRange;

        pub type Query = DateTimeRange;
        // getはファイルを返すのでResponse型の定義がない
    }

    pub mod post {
        use serde_derive::*;

        // CSVファイルを受け付けるのでリクエストデータはない
        #[derive(Debug, Clone, Eq, PartialEq, Hash, Default, Deserialize, Serialize)]
        // 受領したログの数を返す
        pub struct Response(pub usize);
    }
}

pub mod logs {
    pub mod get {
        use crate::{DateTimeRange, Log};
        use serde_derive::*;

        pub type Query = DateTimeRange;

        #[derive(Debug, Clone, Eq, PartialEq, Hash, Default, Deserialize, Serialize)]
        // 保存しているログをすべて返す
        pub struct Response(pub Vec<Log>);
    }

    pub mod post {
        use chrono::{DateTime, Utc};
        use serde_derive::*;

        // 説明した通りのデータを受け付ける
        #[derive(Debug, Clone, Eq, PartialEq, Hash, Default, Deserialize, Serialize)]
        pub struct Request {
            pub user_agent: String,
            pub response_time: i32,
            pub timestamp: Option<DateTime<Utc>>,
        }
        // Acceptedを返すのでResponseデータ型の定義はない
    }
}


pub fn add(left: usize, right: usize) -> usize {
    left + right
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn it_works() {
        let result = add(2, 2);
        assert_eq!(result, 4);
    }
}
