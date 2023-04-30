import React from 'react';

const Categories = (props) => {
  if (!props.categories) {
    return null;
  }

  return (
    <div className={"container mm-4 mt-5"}>
      <div className={"row"}>
        <div className={"table-responsive"}>
          <table className={"table table-striped"}>
            <thead>
              <tr>
                <th scope={"col"}>Name</th>
              </tr>
            </thead>
            <tbody>
              {props.categories.map((term) => {
                return (
                  <tr key={term}>
                    <td>{term}</td>
                  </tr>
                );
              })}
            </tbody>
          </table>
        </div>
      </div>
    </div>
  );
};

export default Categories;

// import React from 'react';

// const categories = (props) => {
//     return (
//         <div className={"container mm-4 mt-5"}>
//             <div className={"row"}>
//                 <div className={"table-responsive"}>
//                     <table className={"table table-striped"}>
//                         <thead>
//                         <tr>
//                             <th scope={"col"}>Name</th>
//                         </tr>
//                         </thead>
//                         <tbody>
//                         {props.categories.map((term) => {
//                             return (
//                                 <tr>
//                                     <td>{term}</td>
//                                 </tr>
//                             );
//                         })}
//                         </tbody>
//                     </table>
//                 </div>
//             </div>
//         </div>
//     )
// }

// export default categories;