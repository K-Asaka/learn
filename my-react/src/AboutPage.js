import { useNavigate } from 'react-router-dom';

export default function AboutPage() {
  // navigate関数を取得
  const navigate = useNavigate();
  // トップページに移動
  const handleClick = () => navigate('/');

  return (
    <>
      <p>Aboutページです。</p>
      <button type="button" onClick={handleClick}>
        トップへ移動</button>
    </>
  );
}