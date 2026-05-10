import { useState } from 'react';
import { createPortal } from 'react-dom';
import './PortalBasic.css';

export default function PortalBasic() {
    // ダイアログの開閉状態を表すState(falseで閉じた状態)
    const [show, setShow] = useState(false);
    // ボタンクリック時のハンドラー(Stateをオンオフ)
    const handleDialog = () => setShow(s => !s);

    return (
        <form>
            <button type="button" onClick={handleDialog}
                disabled={show}>
                    ダイアログを表示
                </button>
                {show && createPortal(
                    <div className="dialog">
                        <p>Portalで生成されたダイアログ</p>
                        <button type="button" onClick={handleDialog}>
                            閉じる
                        </button>
                    </div>,
                    document.getElementById('dialog')
                )}
        </form>
    );
}
