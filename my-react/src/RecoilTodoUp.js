import { useRecoilState } from 'recoil';
import { useState } from 'react';
import { idsAtom, todoListSelector } from './store/atomUp';
import './StateTodo.css';

export default function RecoilTodoUp() {
    const [title, setTitle] = useState('');
    // Atom/Selectorから値、セッターを取得
    const [todo, setTodo] = useRecoilState(todoListSelector);
    const [ids, setIds] = useRecoilState(idsAtom);

    // テキストボックスへの入力をStateに反映
    const handleChangeTitle = e => setTitle(e.target.value);

    // [追加]ボタンクリックでTodo項目を追加
    const handleAdd = () => {
        // id群の最大値から次のid値(+1)を取得
        const newId = Math.max(...(ids.length ? ids : [0])) + 1;
        setTodo({
            type: 'add',
            newItem: {
                id: newId,
                title: title,
                isDone: false
            }
        });
    };

    // [済]ボタンクリックで該当のTodo項目を作業済としてマーク
    const handleDone = e => {
        setTodo({
            type: 'done',
            id: Number(e.target.dataset.id)
        });
    };

    // [削除]ボタンクリックで該当のTodo項目を削除
    const handleRemove = e => {
        setTodo({
            type: 'remove',
            id: Number(e.target.dataset.id)
        });
    };

    return (
        <div>
            <label>
                やること：
                <input type="text" name="todo"
                    value={title} onChange={handleChangeTitle} />
            </label>
            <button type="button"
                onClick={handleAdd}>追加</button>
            <hr />
            <ul>
                {/*Todoリストを順に出力 */}
                {todo.map(item => (
                    <li key={item.id}
                        className={item.isDone ? 'done' : ''}>
                        {item.title}
                        <button type="button"
                            onClick={handleDone} data-id={item.id}>済
                        </button>
                        <button type="button"
                            onClick={handleRemove} data-id={item.id}>削除
                        </button>
                    </li>
                ))}
            </ul>
        </div>
    );
}
