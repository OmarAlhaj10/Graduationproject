// import { useState } from 'react';
// import { useNavigate } from 'react-router-dom';
// import { apiService } from '../services/apiService';
// import { useAuth } from '../components/AuthContext';
//
// const LoginPage = () => {
//   const [email, setEmail] = useState('');
//   const [password, setPassword] = useState('');
//   const [error, setError] = useState('');
//   const [isLoading, setIsLoading] = useState(false);
//   const navigate = useNavigate();
//   const { login } = useAuth();
//
//   const handleSubmit = async (e: React.FormEvent) => {
//     e.preventDefault();
//     setError('');
//     setIsLoading(true);
//
//     try {
//       const response = await apiService.login({ email, password });
//       login(response);
//       navigate('/');
//     } catch (err: any) {
//       setError(err.message || 'Failed to login. Please try again.');
//     } finally {
//       setIsLoading(false);
//     }
//   };
//
//   return (
//     <div className="h-96 flex items-center justify-center bg-bckgroung_main shadow-lg shadow-red-600">
//       <div className="max-w-md w-full space-y-8">
//         <div>
//           <h2 className="mt-6 text-center text-3xl font-extrabold text-red-600">
//             Sign in to your account
//           </h2>
//         </div>
//         <form className="mt-8 space-y-6" onSubmit={handleSubmit}>
//           <div className="rounded-md shadow-sm space-y-4">
//             <div>
//               <label htmlFor="email" className="sr-only ">
//                 Email address
//               </label>
//               <input
//                 id="email"
//                 name="email"
//                 type="email"
//                 autoComplete="email"
//                 required
//                 className="appearance-none rounded relative block w-full px-3 py-2 border border-gray-300 placeholder-gray-500 text-gray-900 focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 focus:z-10 sm:text-sm"
//                 placeholder="Email address"
//                 value={email}
//                 onChange={(e) => setEmail(e.target.value)}
//                 disabled={isLoading}
//               />
//             </div>
//             <div>
//               <label htmlFor="password" className="sr-only">
//                 Password
//               </label>
//               <input
//                 id="password"
//                 name="password"
//                 type="password"
//                 autoComplete="current-password"
//                 required
//                 className="appearance-none rounded relative block w-full px-3 py-2 border border-gray-300 placeholder-gray-500 text-gray-900 focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 focus:z-10 sm:text-sm"
//                 placeholder="Password"
//                 value={password}
//                 onChange={(e) => setPassword(e.target.value)}
//                 disabled={isLoading}
//               />
//             </div>
//           </div>
//
//           {error && (
//             <div className="rounded-md bg-red-50 p-4">
//               <div className="flex">
//                 <div className="ml-3">
//                   <h3 className="text-sm font-medium text-red-800">{error}</h3>
//                 </div>
//               </div>
//             </div>
//           )}
//
//           <div>
//             <button
//               type="submit"
//               disabled={isLoading}
//               className="group relative w-full flex justify-center py-2 px-4 border border-transparent text-sm font-medium rounded-md text-white bg-red-600 hover:bg-red-800 duration-250 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-indigo-500 disabled:opacity-50 disabled:cursor-not-allowed"
//             >
//               {isLoading ? 'Signing in...' : 'Sign in'}
//             </button>
//           </div>
//         </form>
//       </div>
//     </div>
//   );
// };
//
// export default LoginPage;


// import { useState, useEffect } from 'react';
// import { useNavigate } from 'react-router-dom';
// import { apiService } from '../services/apiService';
// import { useAuth } from '../components/AuthContext';
//
// const LoginPage = () => {
//   const [email, setEmail] = useState('');
//   const [password, setPassword] = useState('');
//   const [error, setError] = useState('');
//   const [isLoading, setIsLoading] = useState(false);
//   const navigate = useNavigate();
//   const { login } = useAuth();
//
//   // Auto-login effect
//   useEffect(() => {
//     const autoLoginEmail = sessionStorage.getItem('autoLoginEmail');
//     const autoLoginPassword = sessionStorage.getItem('autoLoginPassword');
//
//     console.log('Checking for auto-login credentials:', { autoLoginEmail, autoLoginPassword });
//
//     if (autoLoginEmail && autoLoginPassword) {
//       console.log('Auto-login credentials found, proceeding with auto-login');
//
//       // Clear the session storage immediately
//       sessionStorage.removeItem('autoLoginEmail');
//       sessionStorage.removeItem('autoLoginPassword');
//
//       // Set the form values
//       setEmail(autoLoginEmail);
//       setPassword(autoLoginPassword);
//
//       // Auto-submit after a longer delay to ensure everything is ready
//       setTimeout(() => {
//         console.log('Attempting auto-login with:', autoLoginEmail);
//         handleAutoLogin(autoLoginEmail, autoLoginPassword);
//       }, 1000);
//     } else {
//       console.log('No auto-login credentials found');
//     }
//   }, []);
//
//   const handleAutoLogin = async (autoEmail: string, autoPassword: string) => {
//     console.log('handleAutoLogin called with:', autoEmail, autoPassword);
//     setIsLoading(true);
//     setError('');
//
//     try {
//       console.log('Attempting API login...');
//       const response = await apiService.login({
//         email: autoEmail,
//         password: autoPassword
//       });
//       console.log('API login successful:', response);
//       login(response);
//       navigate('/');
//     } catch (err: any) {
//       console.error('Auto-login failed:', err);
//       setError(err.message || 'Auto-login failed. Please login manually.');
//     } finally {
//       setIsLoading(false);
//     }
//   };
//
//   const handleSubmit = async (e: React.FormEvent) => {
//     e.preventDefault();
//     setError('');
//     setIsLoading(true);
//
//     try {
//       const response = await apiService.login({ email, password });
//       login(response);
//       navigate('/');
//     } catch (err: any) {
//       setError(err.message || 'Failed to login. Please try again.');
//     } finally {
//       setIsLoading(false);
//     }
//   };
//
//   return (
//       <div className="h-96 flex items-center justify-center bg-bckgroung_main shadow-lg shadow-red-600">
//         <div className="max-w-md w-full space-y-8">
//           <div>
//             <h2 className="mt-6 text-center text-3xl font-extrabold text-red-600">
//               Sign in to your account
//             </h2>
//           </div>
//           <form className="mt-8 space-y-6" onSubmit={handleSubmit}>
//             <div className="rounded-md shadow-sm space-y-4">
//               <div>
//                 <label htmlFor="email" className="sr-only ">
//                   Email address
//                 </label>
//                 <input
//                     id="email"
//                     name="email"
//                     type="email"
//                     autoComplete="email"
//                     required
//                     className="appearance-none rounded relative block w-full px-3 py-2 border border-gray-300 placeholder-gray-500 text-gray-900 focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 focus:z-10 sm:text-sm"
//                     placeholder="Email address"
//                     value={email}
//                     onChange={(e) => setEmail(e.target.value)}
//                     disabled={isLoading}
//                 />
//               </div>
//               <div>
//                 <label htmlFor="password" className="sr-only">
//                   Password
//                 </label>
//                 <input
//                     id="password"
//                     name="password"
//                     type="password"
//                     autoComplete="current-password"
//                     required
//                     className="appearance-none rounded relative block w-full px-3 py-2 border border-gray-300 placeholder-gray-500 text-gray-900 focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 focus:z-10 sm:text-sm"
//                     placeholder="Password"
//                     value={password}
//                     onChange={(e) => setPassword(e.target.value)}
//                     disabled={isLoading}
//                 />
//               </div>
//             </div>
//
//             {error && (
//                 <div className="rounded-md bg-red-50 p-4">
//                   <div className="flex">
//                     <div className="ml-3">
//                       <h3 className="text-sm font-medium text-red-800">{error}</h3>
//                     </div>
//                   </div>
//                 </div>
//             )}
//
//             <div>
//               <button
//                   type="submit"
//                   disabled={isLoading}
//                   className="group relative w-full flex justify-center py-2 px-4 border border-transparent text-sm font-medium rounded-md text-white bg-red-600 hover:bg-red-800 duration-250 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-indigo-500 disabled:opacity-50 disabled:cursor-not-allowed"
//               >
//                 {isLoading ? 'Signing in...' : 'Sign in'}
//               </button>
//             </div>
//           </form>
//         </div>
//       </div>
//   );
// };
//
// export default LoginPage;


import { useState, useEffect } from 'react';
import { useNavigate } from 'react-router-dom';
import { apiService } from '../services/apiService';
import { useAuth } from '../components/AuthContext';

const LoginPage = () => {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [error, setError] = useState('');
  const [isLoading, setIsLoading] = useState(false);
  const navigate = useNavigate();
  const { login } = useAuth();

  // Auto-login effect
  useEffect(() => {
    const urlParams = new URLSearchParams(window.location.search);
    const urlEmail = urlParams.get('autoEmail');
    const urlPassword = urlParams.get('autoPassword');

    // Check URL parameters first (Method 3)
    if (urlEmail && urlPassword) {
      console.log('Found auto-login credentials in URL:', { urlEmail, urlPassword });
      setEmail(urlEmail);
      setPassword(urlPassword);

      // Clear URL parameters
      window.history.replaceState({}, document.title, window.location.pathname);

      setTimeout(() => {
        console.log('Attempting auto-login from URL params');
        handleAutoLogin(urlEmail, urlPassword);
      }, 1000);
      return;
    }

    // Check sessionStorage (Method 1)
    let autoLoginEmail = sessionStorage.getItem('autoLoginEmail');
    let autoLoginPassword = sessionStorage.getItem('autoLoginPassword');

    // If not in sessionStorage, check localStorage (Method 2)
    if (!autoLoginEmail || !autoLoginPassword) {
      autoLoginEmail = localStorage.getItem('autoLoginEmail');
      autoLoginPassword = localStorage.getItem('autoLoginPassword');
      console.log('Checking localStorage for credentials:', { autoLoginEmail, autoLoginPassword });
    }

    console.log('Checking for auto-login credentials:', { autoLoginEmail, autoLoginPassword });

    if (autoLoginEmail && autoLoginPassword) {
      console.log('Auto-login credentials found, proceeding with auto-login');

      // Clear the storage
      sessionStorage.removeItem('autoLoginEmail');
      sessionStorage.removeItem('autoLoginPassword');
      localStorage.removeItem('autoLoginEmail');
      localStorage.removeItem('autoLoginPassword');

      // Set the form values
      setEmail(autoLoginEmail);
      setPassword(autoLoginPassword);

      // Auto-submit after a delay
      setTimeout(() => {
        console.log('Attempting auto-login with:', autoLoginEmail);
        handleAutoLogin(autoLoginEmail, autoLoginPassword);
      }, 1000);
    } else {
      console.log('No auto-login credentials found');
    }
  }, []);

  const handleAutoLogin = async (autoEmail: string, autoPassword: string) => {
    console.log('handleAutoLogin called with:', autoEmail, autoPassword);
    setIsLoading(true);
    setError('');

    try {
      console.log('Attempting API login...');
      const response = await apiService.login({
        email: autoEmail,
        password: autoPassword
      });
      console.log('API login successful:', response);
      login(response);
      navigate('/');
    } catch (err: any) {
      console.error('Auto-login failed:', err);
      setError(err.message || 'Auto-login failed. Please login manually.');
    } finally {
      setIsLoading(false);
    }
  };

  const handleSubmit = async (e: React.FormEvent) => {
    e.preventDefault();
    setError('');
    setIsLoading(true);

    try {
      const response = await apiService.login({ email, password });
      login(response);
      navigate('/');
    } catch (err: any) {
      setError(err.message || 'Failed to login. Please try again.');
    } finally {
      setIsLoading(false);
    }
  };

  return (
      <div className="h-96 flex items-center justify-center bg-bckgroung_main shadow-lg shadow-red-600">
        <div className="max-w-md w-full space-y-8">
          <div>
            <h2 className="mt-6 text-center text-3xl font-extrabold text-red-600">
              Sign in to your account
            </h2>
          </div>
          <form className="mt-8 space-y-6" onSubmit={handleSubmit}>
            <div className="rounded-md shadow-sm space-y-4">
              <div>
                <label htmlFor="email" className="sr-only ">
                  Email address
                </label>
                <input
                    id="email"
                    name="email"
                    type="email"
                    autoComplete="email"
                    required
                    className="appearance-none rounded relative block w-full px-3 py-2 border border-gray-300 placeholder-gray-500 text-gray-900 focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 focus:z-10 sm:text-sm"
                    placeholder="Email address"
                    value={email}
                    onChange={(e) => setEmail(e.target.value)}
                    disabled={isLoading}
                />
              </div>
              <div>
                <label htmlFor="password" className="sr-only">
                  Password
                </label>
                <input
                    id="password"
                    name="password"
                    type="password"
                    autoComplete="current-password"
                    required
                    className="appearance-none rounded relative block w-full px-3 py-2 border border-gray-300 placeholder-gray-500 text-gray-900 focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 focus:z-10 sm:text-sm"
                    placeholder="Password"
                    value={password}
                    onChange={(e) => setPassword(e.target.value)}
                    disabled={isLoading}
                />
              </div>
            </div>

            {error && (
                <div className="rounded-md bg-red-50 p-4">
                  <div className="flex">
                    <div className="ml-3">
                      <h3 className="text-sm font-medium text-red-800">{error}</h3>
                    </div>
                  </div>
                </div>
            )}

            <div>
              <button
                  type="submit"
                  disabled={isLoading}
                  className="group relative w-full flex justify-center py-2 px-4 border border-transparent text-sm font-medium rounded-md text-white bg-red-600 hover:bg-red-800 duration-250 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-indigo-500 disabled:opacity-50 disabled:cursor-not-allowed"
              >
                {isLoading ? 'Signing in...' : 'Sign in'}
              </button>
            </div>
          </form>
        </div>
      </div>
  );
};

export default LoginPage;