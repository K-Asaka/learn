import { Helmet } from 'react-helmet-async';
import { useMatches } from 'react-router-dom';

export default function MyHeader(props) {
  let {
    title = 'React入門',
    keywords = 'React, JavaScript, フレームワーク',
    description = 'React入門のサンプルです。'
  } = useMatches().at(-1).handle ?? {};
  // Propsの値をプレイスホルダーに反映
  title = title.replace('%s', props.title);
  keywords = keywords.replace('%s', props.keywords);
  description = description.replace('%s', props.description);
  return (
    // <head>要素に埋め込む要素を準備
    <Helmet>
      <title>{title}</title>
      <meta name="keywords" content={keywords} />
      <meta name="description" content={description} />
    </Helmet>
  );
}