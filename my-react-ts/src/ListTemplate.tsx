import React, { ReactNode } from 'react';
import type { Book } from './Book';

// Propsの型宣言
type ListTemplateProps = {
    src: Array<Book>,
    children: (b: Book) => ReactNode
};

export default function ListTemplate({ src, children }: ListTemplateProps) {
    return (
        <dl>
            {
                src.map((elem, index) => (
                    <React.Fragment key={elem.isbn}>
                        {children(elem)}
                    </React.Fragment>
                ))
            }
        </dl>
    );
}
