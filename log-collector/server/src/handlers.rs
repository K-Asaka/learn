use actix_web::{HttpResponse, State};
use failure::Error;

use crate::Server;

/// POST /csvのハンドラ
pub fn handle_post_csv(server: State<Server>) -> Result<HttpResponse, Error> {
    unimplemented!()
}

/// POST /logsのハンドラ
pub fn handle_post_logs(server: State<Server>) -> Result<HttpResponse, Error> {
    unimplemented!()
}

/// GET /logsのハンドラ
pub fn handle_get_logs(server: State<Server>) -> Result<HttpResponse, Error> {
    unimplemented!()
}

/// GET /csvのハンドラ
pub fn handle_get_csv(server: State<Server>) -> Result<HttpResponse, Error> {
    unimplemented!()
}
