mod value_scope;
use value_scope::{value_scope, move_semantics};
use value_scope::nll;

fn main() {
    value_scope();
    move_semantics();
    nll();
}
