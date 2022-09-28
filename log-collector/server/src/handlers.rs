use actix_web::{HttpResponse, State};
use actix_web::{Json, Query};
use failure::Error;
use log::debug;

use crate::Server;

/// POST /csvのハンドラ
pub fn handle_post_csv(server: State<Server>) -> Result<HttpResponse, Error> {
    // POSTされたファイルはActix Webでは簡単には扱えないのでここではまだコードなし

    // レスポンスはDefaultでダミーデータを生成
    let logs = Default::default();

    Ok(HttpResponse::Ok().json(api::csv::post::Response(logs)))
}

/// POST /logsのハンドラ
pub fn handle_post_logs(
    server: State<Server>,
    // POSTのボディはJson<T>を引数に書くと自動的にデシリアライズされて渡される
    log: Json<api::logs::post::Request>,
) -> Result<HttpResponse, Error> {
    // Json<T>はTへのDerefを実装しているので内部ではほぼそのままTの値として扱える
    debug!("{:?}", log);
    // レスポンスはAccepted
    Ok(HttpResponse::Accepted().finish())
}

/// GET /logsのハンドラ
pub fn handle_get_logs(
    server: State<Server>,
    // クエリパラメータはQuery<T>を引数に書くと自動的にデシリアライズされて渡される
    range: Query<api::logs::get::Query>,
) -> Result<HttpResponse, Error> {
    debug!("{:?}", range);

    let logs = Default::default();

    Ok(HttpResponse::Ok().json(api::logs::get::Response(logs)))
}

/// GET /csvのハンドラ
pub fn handle_get_csv(
    server: State<Server>,
    range: Query<api::csv::get::Query>,
) -> Result<HttpResponse, Error> {
    debug!("{:?}", range);

    // CSVファイルはバイナリデータにして返す
    let csv: Vec<u8> = vec![];
    Ok(HttpResponse::Ok()
        .header("Content-Type", "text/csv")
        .body(csv))
}
